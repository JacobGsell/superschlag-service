package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.repository.AvatarRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AvatarServiceTest {

    @Mock
    AvatarRepository avatarRepositoryMock;

    @InjectMocks
    AvatarService sut;

    @BeforeEach
    public void setUp() {
        avatarRepositoryMock = Mockito.mock(AvatarRepository.class);
    }

    @Test
    public void findAvatarById_should_get_AvatarOptional_on_existing_id() {
        // Arrange
        long avatarId = 0;
        Avatar expected = new Avatar();
        Optional<Avatar> expectedOptional = Optional.of(expected);

        when(avatarRepositoryMock.findById(avatarId)).thenReturn(expectedOptional);

        // Act
        Avatar actual = sut.findAvatarById(avatarId);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void findAvatarById_should_throw_EntityNotFoundException_on_empty_AvatarOptional() {
        // Arrange
        long avatarId = 0;
        Optional<Avatar> actual = Optional.empty();

        when(avatarRepositoryMock.findById(avatarId)).thenReturn(actual);

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> sut.findAvatarById(avatarId));
    }
}