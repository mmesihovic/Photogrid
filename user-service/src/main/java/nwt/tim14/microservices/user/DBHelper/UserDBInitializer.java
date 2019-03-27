package nwt.tim14.microservices.user.DBHelper;

import nwt.tim14.microservices.user.Entities.Follow;
import nwt.tim14.microservices.user.Entities.Role;
import nwt.tim14.microservices.user.Entities.User;
import nwt.tim14.microservices.user.Entities.UserRole;
import nwt.tim14.microservices.user.Repositories.FollowRepository;
import nwt.tim14.microservices.user.Repositories.RoleRepository;
import nwt.tim14.microservices.user.Repositories.UserRepository;
import nwt.tim14.microservices.user.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserDBInitializer implements ApplicationRunner {

    private FollowRepository followRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserDBInitializer(FollowRepository followRepository, RoleRepository roleRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.followRepository = followRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long userRows = userRepository.count();
        long roleRows = roleRepository.count();
        long userRoleRows = userRoleRepository.count();
        long followRows = followRepository.count();

        if(userRows == 0) {
            userRepository.save(new User("Mirza", "Mesihovic", new Date(), "mmesihovic", "mmesihovic1@etf.unsa.ba", "1234567", true));
            userRepository.save(new User("Irhad", "Halilovic", new Date(), "ihalilovic", "ihalilovic1@etf.unsa.ba", "12345678", true));
            userRepository.save(new User("Rasim", "Sabanovic", new Date(), "rsabanovic", "rsabanovic1@etf.unsa.ba", "123456789", true));
        }
        if(roleRows == 0) {
            roleRepository.save(new Role("Influenser"));
            roleRepository.save(new Role("debil"));
            roleRepository.save(new Role("Regular User"));
        }
        if(userRoleRows == 0 ) {
            userRoleRepository.save(new UserRole(1L, 3L));
            userRoleRepository.save(new UserRole(2L, 3L));
            userRoleRepository.save(new UserRole(3L, 3L));
        }
        if(followRows == 0) {
            followRepository.save(new Follow(2L, 1L));
            followRepository.save(new Follow(3L, 1L));
        }
    }
}
