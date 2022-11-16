package br.com.biv.creditcard.controller.mapper;

import br.com.biv.creditcard.controller.AccountRequest;
import br.com.biv.creditcard.controller.AccountResponse;
import br.com.biv.creditcard.domain.model.Account;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountToAccountResourceMapper {

    private final ModelMapper modelMapper;

    public Account convertToAccount(AccountRequest accountRequest) {
        return modelMapper.map(accountRequest, Account.class);
    }


    public AccountResponse convertToAccountResponse(Account account) {
        return modelMapper.map(account, AccountResponse.class);
    }

    public List<AccountResponse> convertToAccountResponseList(List<Account> accounts) {
        return accounts
                .stream()
                .map(this::convertToAccountResponse)
                .collect(Collectors.toList());
    }
}
