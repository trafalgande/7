import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrentUser {
    private String accountName;
    private String accountPassword;
    private int accountId;
}
