package ac.kr.ajou.refactoring;

import java.util.List;

public class LoginService {

    private final DataBaseService dataBaseService;
    private final AccountService accountService = new AccountService(this);

    public LoginService () {
        this.dataBaseService = new DataBaseService();
    }

    public boolean login (String userId, String password) {
        if (userId != null && !userId.isEmpty()) {
            if (dataBaseService.userExists(userId)) {
                Player player = dataBaseService.getPlayerById(userId);
                if (player.getPassword().equals(password)) {
                    return true;
                } else {
                    return false;
                }
            } else
                {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getUserNameById(String id) {
        return accountService.getUserNameById(id);
    }

    public List<Player> getAge(int a) {
        return accountService.getAge(a);
    }

    public DataBaseService getDataBaseService() {
        return dataBaseService;
    }
}
