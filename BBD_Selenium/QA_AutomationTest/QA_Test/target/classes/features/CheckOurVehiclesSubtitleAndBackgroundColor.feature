@testOurVehiclesSubtitleAndBgrColor

  Feature: To go to Landrover URL
    Scenario: Open the Landrover Website
      Given I open landrover home page with title "Premium 4X4 Vehicles & Luxury SUV's - Land Rover UK"
        When I view Our Vehicle sub title and background color in Stacked Blocks
          Then I will check Our Vehicle title is "OUR VEHICLES" and background color is "#e9ecec"