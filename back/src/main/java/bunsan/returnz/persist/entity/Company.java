package bunsan.returnz.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	@Id
	@Column(name = "COMPANY_CODE")
	private String code;

	@Column(name = "COMPANY_NAME", unique = true)
	private String companyName;

	@OneToOne(mappedBy = "company")
	private CompanyDetail companyDetail;

}
