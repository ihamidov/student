package az.ingress.student.search;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchCriteria {

    private String key; //first name, last name
    private Object value; // Ibrahim, Ayaz
    private SearchOperation operation; //Equal, Like, StratsWIth
}
