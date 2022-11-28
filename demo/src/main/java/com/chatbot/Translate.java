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
      projectId="steam-talent-369823"; //Sets up google auth, this probably will not work on other machines.
      client = TranslationServiceClient.create();
     parent = LocationName.of(projectId, "global");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
      // Translate text to target language.
      public String translateText(String targetLanguage, String text)
         {
    
          // Supported Locations: `global`, [glossary location], or [model location]
          // Glossaries must be hosted in `us-central1`
          // Custom Models must use the same location as your model. (us-central1)

    
          // Supported Mime Types: https://cloud.google.com/translate/docs/supported-formats
          try{
          TranslateTextRequest request =
              TranslateTextRequest.newBuilder() //creates the request
                  .setParent(parent.toString())
                  .setMimeType("text/plain")
                  .setTargetLanguageCode(targetLanguage)
                  .addContents(text)
                  .build();
    
          TranslateTextResponse response = client.translateText(request); //builds the text response
    
          // Display the translation for each input text provided
          StringBuilder resp = new StringBuilder();
          for (Translation translation : response.getTranslationsList()) { //applys the translated text to a stringbuilder
            resp.append( translation.getTranslatedText());
          }
          return(resp.toString()); //returns the translated text
        } catch (Exception e) {
          return("Could not connect to translation server");
        }
      }}
    
