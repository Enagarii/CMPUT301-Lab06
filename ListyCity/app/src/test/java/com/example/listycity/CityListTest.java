package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CityListTest
{
	private CityList mockCityList()
	{
		CityList cityList = new CityList();
		cityList.add(mockCity());
		return cityList;
	}

	private City mockCity()
	{
		return new City("Edmonton", "Alberta");
	}

	@Test
	void testAdd()
	{
		CityList cityList = mockCityList();
		assertEquals(1, cityList.getCities().size());
		City city = new City("Regina", "Saskatchewan");
		cityList.add(city);
		assertEquals(2, cityList.getCities().size());
		assertTrue(cityList.getCities().contains(city));
	}

	@Test
	void testAddException()
	{
		CityList cityList = mockCityList();
		City city = new City("Yellowknife", "Northwest Territories");
		cityList.add(city);
		assertThrows(IllegalArgumentException.class, () ->
		{
			cityList.add(city);
		});
	}

	@Test
	void testGetCities() {
		CityList cityList = mockCityList();
		// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
		// is the same as the city returned by mockCity()
		assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
		// This pushes down the original city
		City city = new City("Charlottetown", "Prince Edward Island");
		cityList.add(city);
		// Now the original city should be at position 1
		assertEquals(0, city.compareTo(cityList.getCities().get(0)));
		assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
	}

	@Test
	void testHasCity()
	{
		CityList cl = mockCityList();

		// Test if it has the default city
		assertTrue(cl.hasCity(mockCity()));

		// Test if it can identify a newly added city
		City city = new City("Calgary", "Alberta");
		cl.add(city);
		assertTrue(cl.hasCity(city));
	}


	@Test
	void testDeleteCity()
	{
		CityList cl = mockCityList();
		City city = new City("Calgary", "Alberta");
		cl.add(city);
		cl.delete(city);

		assertEquals(1, cl.getCities().size());
		assertFalse(cl.getCities().contains(city));
	}

	@Test
	void testDeleteCityException()
	{
		CityList cl = mockCityList();
		City city = new City("Calgary", "Alberta");
		cl.add(city);
		cl.delete(city);

		assertEquals(1, cl.getCities().size());
		assertFalse(cl.getCities().contains(city));

		assertThrows(IllegalArgumentException.class, () ->
		{
			cl.delete(city);
		});
	}

	@Test
	void testCountCities()
	{
		CityList cl = mockCityList();
		assertEquals(1, cl.countCities());

		City city = new City("Calgary", "Alberta");
		cl.add(city);
		assertEquals(2, cl.countCities());

		cl.delete(mockCity());
		assertEquals(1, cl.countCities());

		cl.delete(city);
		assertEquals(0, cl.countCities());

	}


}