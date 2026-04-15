@contact
Feature: Navegación a Contact desde LG Ads

  Scenario: Hacer clic en el botón Contact, verificar títulos en la página de contacto y regresar al home
    Given I navigate to "https://lgads.tv/"
    When I click the Contact button
    Then I should be redirected to the contact page
    And I should see the Contact page titles
    When I click the LG Ad Solutions link
    Then I should be redirected to the homepage
    And I should see the welcome text "Welcome to the Future of TV Advertising"
