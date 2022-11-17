package br.com.biv.creditcard.controller;

import br.com.biv.creditcard.controller.mapper.merchant.MerchanToMerchanResourceMapper;
import br.com.biv.creditcard.controller.resource.merchant.MerchantRequest;
import br.com.biv.creditcard.controller.resource.merchant.MerchantResponse;
import br.com.biv.creditcard.domain.model.Merchant;
import br.com.biv.creditcard.domain.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@EnableSwagger2
@RestController
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    MerchantService merchantService;
    @Autowired
    MerchanToMerchanResourceMapper merchanToMerchanResourceMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantResponse createMerchant(@RequestBody @Valid MerchantRequest merchantRequest) {
        log.info("[POST][REQUEST]: Creating merchant {}", merchantRequest.getName());
        Merchant merchant = merchanToMerchanResourceMapper.convertToAccount(merchantRequest);
        System.out.println("REQUEST: " + merchant.getName());
        Merchant merchantSaved = merchantService.save(merchant);
        System.out.println("SAVED:" + merchantSaved.getName());
        MerchantResponse merchantResponse = merchanToMerchanResourceMapper.convertToMerchantResponse(merchantSaved);
        System.out.println("RESPONSE:" + merchantResponse.getName());
        log.info("[POST][RESPONSE]: Merchant create with success, merchantId {}.", merchantSaved.getMerchantId());
        return merchantResponse;
    }

    @GetMapping("/{merchantId}")
    public MerchantResponse getById(@PathVariable(value = "merchantId", required = true) Long merchantId) {
        log.info("[GET-BY-ID][REQUEST]: Searching for merchantId {}", merchantId);
        Optional<Merchant> merchantById = merchantService.findById(merchantId);
        final MerchantResponse merchantResponse = merchanToMerchanResourceMapper.convertToMerchantResponse(merchantById.get());
        log.info("[GET-BY-ID][RESPONSE] Found merchants information.");
        return merchantResponse;
    }

    @GetMapping
    public ResponseEntity<List<MerchantResponse>> listAll() {
        log.info("[LIST-ALL [REQUEST]: Listing all merchants");
        List<Merchant> merchants = merchantService.listAll();
        List<MerchantResponse> merchantResponse = merchanToMerchanResourceMapper.convertToMerchantsResponseList(merchants);
        log.info("[LIST-ALL][RESPONSE] Successfully listed merchants");
        return ResponseEntity.status(HttpStatus.OK).body(merchantResponse);
    }

    @DeleteMapping("/{merchantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(value = "merchantId", required = false) Long merchantId) {
        merchantService.deleteById(merchantId);
        log.info("[DELETE]: Delete merchantId {}", merchantId);
    }
}
