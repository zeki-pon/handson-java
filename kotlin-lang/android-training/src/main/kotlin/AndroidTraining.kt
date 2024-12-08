class AndroidTraining {
    fun compareTimeSpent(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
        return timeSpentToday > timeSpentYesterday
    }

    fun displayCityWeather(city: String, lowTemperature: Int, highTemperature: Int, chanceOfRain: Int) {
        println("City: $city")
        println("Low temperature: $lowTemperature, High temperature: $highTemperature")
        println("Chance of rain: $chanceOfRain%")
        println()
    }
}