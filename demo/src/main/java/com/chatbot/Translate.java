package com.chatbot;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.io.IOException;

public class Translate {
  public static String projectId;
  public static TranslationServiceClient client;
  public static LocationName parent;
  public void init(){
    try {
      projectId="steam-talent-369823";
      client = TranslationServiceClient.create();
     parent = LocationName.of(projectId, "global");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
      // Translate text to target language.
      public String translateText(String targetLanguage, String text)
          throws IOException {
    
          // Supported Locations: `global`, [glossary location], or [model location]
          // Glossaries must be hosted in `us-central1`
          // Custom Models must use the same location as your model. (us-central1)

    
          // Supported Mime Types: https://cloud.google.com/translate/docs/supported-formats
          TranslateTextRequest request =
              TranslateTextRequest.newBuilder()
                  .setParent(parent.toString())
                  .setMimeType("text/plain")
                  .setTargetLanguageCode(targetLanguage)
                  .addContents(text)
                  .build();
    
          TranslateTextResponse response = client.translateText(request);
    
          // Display the translation for each input text provided
          StringBuilder resp = new StringBuilder();
          for (Translation translation : response.getTranslationsList()) {
            resp.append( translation.getTranslatedText());
          }
          return(resp.toString());
        }
      }
    
