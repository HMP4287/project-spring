package project.web;

import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.mock.env.MockEnvironment;
import project.web.dto.ProfileController;

// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class ProfileControllerUnitTest {
        @Test
        public void real_profil이_조회된다() {
            // given
            String expectedProfile = "real";
            MockEnvironment env = new MockEnvironment();
            env.addActiveProfile(expectedProfile);
            env.addActiveProfile("oauth");
            env.addActiveProfile("real-db");

            ProfileController controller = new ProfileController(env);

            // when
            String profile = controller.profile();

            // then
            assertThat(profile).isEqualTo(expectedProfile);

        }

        @Test
        public void real_profile이_없으면_첫_번째가_조회된다() {
            // given
            String expectedProfile = "oauth";
            MockEnvironment env = new MockEnvironment();

            env.addActiveProfile(expectedProfile);
            env.addActiveProfile("real-db");

            ProfileController controller = new ProfileController(env);

            // when
            String profile = controller.profile();

            // then
            assertThat(profile).isEqualTo(expectedProfile);
        }

        @Test
        public void active_profile이_없으면_default가_조회된다() {
            // given
            String expectedProfile = "default";
            MockEnvironment env = new MockEnvironment();
            ProfileController controller = new ProfileController(env);

            // when
            String profile = controller.profile();

            // then
            assertThat(profile).isEqualTo(expectedProfile);
        }
}
