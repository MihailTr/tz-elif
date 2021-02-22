package dev.tmtx.tzelif.controllers;

import dev.tmtx.tzelif.entities.Bank;
import dev.tmtx.tzelif.entities.CalcResult;
import dev.tmtx.tzelif.entities.UserInput;
import dev.tmtx.tzelif.services.BankService;
import dev.tmtx.tzelif.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private BankService bankService;
    private CalcService calcService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }
    @Autowired
    public void setCalcService(CalcService calcService) {
        this.calcService = calcService;
    }

    @RequestMapping({"/", "/index"})
//    @ResponseBody
//    @GetMapping({"/", "/index"})
//    @GetMapping("/index")
    public String homePage(Model model) {
        List<Bank> allBanks = bankService.getAllBanks();
        model.addAttribute("banks", allBanks);
        return "index";
    }
    @GetMapping("/calc")
    public String calcPage(Model model){
        UserInput userInput = new UserInput();
        model.addAttribute("userInput", userInput);

        List<Bank> allBanks = bankService.getAllBanks();
        model.addAttribute("banks", allBanks);
        return "calc";
    }

    @RequestMapping(value = "/result" , method = RequestMethod.POST)
//    public String resultCalc(Model model, @Valid UserInput userInput,
    public String resultCalc(Model model, UserInput userInput,
                             BindingResult result) {
        List<CalcResult> listRes = calcService.listCalcResult(userInput);
        model.addAttribute("listRes", listRes);


        return "calc_res";
    }

    @GetMapping("/delete/{id}")
    public String deleteBankById(@PathVariable("id") Long id) {
        bankService.deleteBankById(id);
        return "redirect:/index";
    }

    @RequestMapping("/add")
    public String newCustomerForm(Map<String, Object> model) {
        Bank bank = new Bank();
        model.put("bank", bank);
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("bank") Bank bank) {
        bankService.save(bank);
        return "redirect:/index";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Bank bank = bankService.getBank(id);
        model.addAttribute("bank", bank);
        return "edit_bank";
    }

    @PostMapping("/edit_bank/{id}")
//    public String updateBank(@PathVariable("id") long id, @Valid Bank bank,
    public String updateBank(@PathVariable("id") long id, Bank bank,
                             BindingResult result) {
        if (result.hasErrors()) {
            bank.setId(id);
            return "edit_bank";
        }

        bankService.save(bank);
        return "redirect:/index";
    }



}
