package com.sap.training.controllers;

import com.sap.training.models.Restaurant;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;
import com.sap.training.services.RestaurantService;
import com.sap.training.services.SecurityService;
import com.sap.training.services.VoteService;
import com.sap.training.services.VotingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Transactional
@Controller
public class VotingController {

    @Resource
    private VotingService votingService;

    @Resource
    private RestaurantService restaurantService;

    @Resource
    private SecurityService securityService;

    @Resource
    private VoteService voteService;

    @RequestMapping(value = "/votings")
    public String listVotings(Model model) {
        List<Voting> votings = votingService.listVotings();
        model.addAttribute("votings", votings);
        return "list-votings";
    }

    @RequestMapping(value = "/voting")
    public String listVotings(@RequestParam("id") int id, Model model) {
        Voting voting = votingService.getVotingById(id);
        List<Restaurant> restaurants = restaurantService.listRestaurants();
        List<Vote> votes = voting.getVotes();
        Vote vote = voting.getUserVote(securityService.getLoggedUser());

        model.addAttribute("voting", voting);
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("vote", vote);
        model.addAttribute("votes", votes);
        return "voting";
    }

    @RequestMapping(value = "/start-voting")
    public String startVoting(Model model, RedirectAttributes redirectAttributes) {
        Voting voting = new Voting();
        votingService.createVoting(voting);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/votings";
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String vote(@Valid Vote vote, RedirectAttributes redirectAttributes) {
        vote.setRestaurant(restaurantService.getRestaurantbyId(vote.getRestaurant().getId()));
        Voting voting = votingService.getVotingById(vote.getVoting().getId());
        vote.setVoting(voting);
        vote.setUser(securityService.getLoggedUser());

        voteService.registerVote(vote);

        redirectAttributes.addFlashAttribute("success", true);
//        votingService.addVote
        return "redirect:/votings";
    }

    @ResponseBody
    @RequestMapping(value = "/votings-json")
    public List<Voting> getRestVotings(Model model) {
        return votingService.listVotings();
    }
}
