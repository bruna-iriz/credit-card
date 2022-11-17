package br.com.biv.creditcard.domain.model;

import br.com.biv.creditcard.domain.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

import static java.util.Objects.isNull;

@Data
@Builder
@Entity
@Table(name = "TB_OPERATION")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPERATION_ID", nullable = false, unique = true)
    private Long operationId;


    @Column(name = "OPERATION_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private OperationType operationType;

    public boolean isCredit() {
        if (isNull(operationType)) {
            return false;
        }
        return operationType == OperationType.CREDIT;
    }
}
