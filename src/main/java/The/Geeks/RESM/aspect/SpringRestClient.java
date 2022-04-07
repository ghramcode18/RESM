// package The.Geeks.RESM.aspect;

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.client.RestTemplate;

// import The.Geeks.RESM.dto.EstatesDto;

// public class SpringRestClient {
//     // TODO : please fix my i have a problem
//     private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8081/api/v1/getAllEstate";
//    // private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/getEstatesEntityById/{id}";
//     // private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/createEstate";
//    // private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/updateEstate";
//   //  private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/delete/{id}";
//     private static RestTemplate restTemplate = new RestTemplate();

//     public static void main(String[] args) {
//         SpringRestClient springRestClient = new SpringRestClient();

//         // springRestClient.createEstate();

//         // springRestClient.getEstatesEntityById();

//         springRestClient.getAllEstate();

//         // springRestClient.updateEstate();

//         // springRestClient.deleteEstatesEntityById();
//     }

//     private void getAllEstate() {

//         HttpHeaders headers = new HttpHeaders();
//         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

//         ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
//                 String.class);

//         System.out.println(result);
//     }

//     // private void getEstatesEntityById() {

//     //     Map<String, String> params = new HashMap<String, String>();
//     //     params.put("id", "1");

//     //     RestTemplate restTemplate = new RestTemplate();
//     //     EstatesDto result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, EstatesDto.class, params);

//     //     System.out.println(result);
//     // }

//     // // private void createEstate() {

//     // //     EstatesDto newEstatesDto = new EstatesDto(18, "buyerName", "propertyName", 1000, 100, 21, null);

//     // //     RestTemplate restTemplate = new RestTemplate();
//     // //     EstatesDto result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newEstatesDto, EstatesDto.class);

//     // //     System.out.println(result);
//     // // }

//     // private void updateEstate() {
//     //     Map<String, String> params = new HashMap<String, String>();
//     //     params.put("id", "1");
//     //     EstatesDto updatedEmployee = new EstatesDto(18, "buyerName", "propertyName", 1000, 100, 21, null);
//     //     ;
//     //     RestTemplate restTemplate = new RestTemplate();
//     //     restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedEmployee, params);
//     // }

//     // private void deleteEstatesEntityById() {
//     //     Map<String, String> params = new HashMap<String, String>();
//     //     params.put("id", "1");
//     //     RestTemplate restTemplate = new RestTemplate();
//     //     restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
//     // }
// }
