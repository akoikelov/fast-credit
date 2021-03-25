package kg.akoikelov.springmvcapp.rest.controllers.superadmin;

import com.fasterxml.jackson.annotation.JsonView;
import kg.akoikelov.springmvcapp.models.CashBox;
import kg.akoikelov.springmvcapp.rest.serializers.CashBoxSerializer;
import kg.akoikelov.springmvcapp.services.CashBoxService;
import kg.akoikelov.springmvcapp.utils.ControllerHelper;
import kg.akoikelov.springmvcapp.utils.PaginationData;
import kg.akoikelov.springmvcapp.utils.ViewsRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/superadmin/cashbox")
public class CashBoxControllerRest {
    @Autowired
    CashBoxService cashBoxService;

    @GetMapping()
    @JsonView(ViewsRest.forList.class)
    public PaginationData<CashBox> list(@RequestParam(value = "pagecount", defaultValue = "1") String page, @RequestParam(value = "pagination", defaultValue = "10") String pagination) {
        int pageCount = ControllerHelper.parseInt(page);
        int paginationCount = ControllerHelper.parseInt(pagination);
        return cashBoxService.getCashBoxList(pageCount, paginationCount);

    }

    @PostMapping()
    public CashBox create(@Valid @RequestBody CashBoxSerializer cashBoxSerializer) {
        CashBox cashBox = cashBoxSerializer.build();
        cashBoxService.create(cashBox);

        return cashBox;
    }

    @PutMapping("/{id}")
    public CashBox update(@PathVariable int id, @Valid @RequestBody CashBoxSerializer cashBoxSerializer) {
        CashBox cashBox = cashBoxService.getCashBox(id);
        if (cashBox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CashBox cashBox1 = cashBoxSerializer.build();
        cashBox1.setId(id);
        boolean ok = cashBoxService.updateCashBox(cashBox1);
        if (!ok) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return cashBox1;
    }

    @GetMapping("/{id}")
    @JsonView(ViewsRest.forList.class)
    public CashBox getByID(@PathVariable int id) {
        CashBox cashBox = cashBoxService.getCashBox(id);
        return cashBox;
    }
}
