Feature: hello world tests

# Gherkin is the syntax feature files are written in.  It has the traditional Given/When/Then
Scenario: Home page
  When I go to the Hello World homepage
  Then "Hello!" should be displayed

#TODO:
# Fill out the step definition for this scenario. Note that when you go to your web site, clicking the hello button will send the browser to http://localhost:8080/hello
Scenario: Link navigates to hello subpage
  Given I am on the Hello World homepage
  When I click the link with id "helloLink"
  Then I am taken to the hello subpage