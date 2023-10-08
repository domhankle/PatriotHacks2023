// import org.springframework.stereotype.Service;
// import org.springframework.web.reactive.function.client.WebClient;

// public class OpenAIService {
//     private final WebClient webClient;

//     public OpenAIService(WebClient.Builder webClientBuilder) {
//         this.webClient = webClientBuilder.build();
//     }

//     public String callOpenAI() {
//         return webClient.get()
//             .uri("/chat/completions")
//             .retrieve()
//             .bodyToMono(String.class)
//             .block();
//     }
// }
