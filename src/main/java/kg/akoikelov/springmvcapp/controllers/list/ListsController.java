package kg.akoikelov.springmvcapp.controllers.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListsController {
    @GetMapping("/transaction")
    public String getListAllTransaction() {
        return "list/gettransaction";
    }

    @GetMapping("/clients")
    public String getListAllClients() {
        return "list/getclients";
    }

    @GetMapping("/deposit")
    public String getListAllDeposit() {
        return "list/getdeposit";
    }

    @GetMapping("/pko")
    public String getListAllPKO() {
        return "list/getpko";
    }

    @GetMapping("/rko")
    public String getListAllRKO() {
        return "list/getrko";
    }

    @GetMapping("/getlastcontract")
    public String getListLastContract() {
        return "list/getlastcontract";
    }

    @GetMapping("/sales")
    public String getListAllSales() {
        return "list/getsales";
    }

    @GetMapping("/shopping")
    public String getListAllShop() {
        return "list/getshop";
    }
}
