@contact
Feature: Navegación a Contact desde LG Ads

  Scenario: Hacer clic en el botón Contact, verificar página y regresar al home
    Given I navigate to "https://lgads.tv/"
    When I click the Contact button
    Then I should be redirected to the contact page
    When I click the LG Ad Solutions link
    Then I should be redirected to the homepage
