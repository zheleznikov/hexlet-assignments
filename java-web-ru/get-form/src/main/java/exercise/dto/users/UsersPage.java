package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Data
public class UsersPage {
    private List<User> users;
    private String term;
}
// END
