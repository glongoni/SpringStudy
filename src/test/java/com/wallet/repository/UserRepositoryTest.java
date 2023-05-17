package com.wallet.repository;

import com.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    public static final String EMAIL = "test@test.com";
    @Autowired
    UserRepository repository;

    @Before
    public void setUp() {
        User u = new User();
        u.setName("Test");
        u.setPassword("123456");
        u.setEmail(EMAIL);
        repository.save(u);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void testFindByEmail() {
        Optional<User> u = repository.findByEmailEquals(EMAIL);
        assertTrue(u.isPresent());
        assertEquals(u.get().getEmail(), EMAIL);
    }


    @Test
    public void testSave() {
        User u = new User();
        u.setName("Test");
        u.setPassword("123456");
        u.setEmail("test@test.com");

        assertNotNull(u);
        User response = repository.save(u);
        assertNotNull(response);
    }
}
