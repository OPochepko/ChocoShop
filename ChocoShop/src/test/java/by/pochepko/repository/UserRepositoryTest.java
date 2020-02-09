package by.pochepko.repository;

import by.pochepko.SpringBtApplication;
import by.pochepko.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBtApplication.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void userRepositoryTest_userRepositorySholdReturnAdminUser() {
        assertThat(userRepository.findUserByEmail("admin@mail.com").getRole())
                .isEqualTo(User.Role.ADMIN);

    }
}