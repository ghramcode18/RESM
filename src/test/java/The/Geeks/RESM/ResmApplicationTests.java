package The.Geeks.RESM;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import The.Geeks.RESM.dto.EstatesDto;
import The.Geeks.RESM.entity.EstatesEntity;
import The.Geeks.RESM.repositories.EstatesRepo;
import The.Geeks.RESM.services.EstatesServicesImp;

@RunWith(MockitoJUnitRunner.class)


class ResmApplicationTests {

	@MockBean
    EstatesRepo estatesRepo;

	@Autowired
    EstatesServicesImp estateServiceImp;


	public void saveEstatesEntityTest() {
		EstatesEntity estatesEntity =new EstatesEntity(1,"ghram","home in damascus",1000,600,11,CurentTime,);
        when(estatesRepo.save(estatesEntity)).thenReturn(estatesEntity);
		assertEquals(estatesEntity,estateServiceImp.save(estatesEntity));
    }
	

	public void saveUserTest() {
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "Pranya", 33, "Pune");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}
    
}
