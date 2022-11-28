# **310 Lab Group 13**
# Individual Assignment:
## **Description:**

### Chatbot description:
- This chatbot handles important safety related questions, and then moves on to having a normal conversation after the safety has been determined. This system allows for translation as well as narration and wikipedia enabled results.
### New Features/Updates:

- Google Translate API support for Japanese, French, Spanish and Latin
- Wikipedia API enabled, the bot can now search for items it doesn't know. Uses the JWiki API which is a lightweight third-party API used to search wikipedia.

### Limitations
- Sometimes the bot is a little eager to search wikipedia if you say something it doesnt understand, returning a random article that somewhat matches what you said. 


### Buffet items: 
- We switched our code over to using AIML library, utilizing existing language recognition tools and simple conversation
- We had previously already created UI, so we decided to just make updates to make it more visually appealing
- We added another topic by adding a seperate bot that can determine more things that are found in most conversations
- Our chatbot can give over 5 different responses outside the two topics as well as it has a large dataset
- Implemented a Text to Speech library called FreeTTS

### JIRA
- ![JIRA](./images/JIRA.PNG)

### Data flow diagrams
- Level 0
  - ![DFD0](./images/DFD0.png)
  - User inputs to chatbot and chatbot checks on message database for the correct reponse
- Level 1
  - ![DFD1](./images/DFD1.png)
  - User input determines chatbotID which changes what patterns it is supposed to understand. After input chatbot determines correct response and delivers it to the interface which shows it to the user.

### Github Charts
- Branches
    - ![Branches](./images/Branches.PNG)

### Unit Testing
![UnitTest](./images/UnitTest.PNG)

### API Features
- User input
- Output
- Current chatbot ID
- Datasets
- Test cases and checks
- Google translate support
- Wikipedia enabled