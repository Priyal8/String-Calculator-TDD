import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
	
	public int add(String numbers) throws Exception
	{
		String[] numbers_arr = numbers.split(",");
		if(empty(numbers)) {
			return 0;
		}
		if(numbers.length() == 1)
		{ 
			return stringToInt(numbers);
		}
		else
		{
			return sum(numbers_arr,numbers);
		}
    }
	private int sum(String[] numbers_arr, String numbers) throws Exception
	{	
		findNegatives(numbers_arr);
		int char_add = checkChar(numbers);
		int sum = 0;
		for(int i = 0; i<numbers_arr.length; i++)
		{
			if(stringToInt(numbers_arr[i])>=0 && stringToInt(numbers_arr[i])<1000)
			{
				sum += stringToInt(numbers_arr[i]);
			}

		}
		return sum+char_add;
	}
	private Map<Character, Integer> charToInt()
	{
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l'};
		Map<Character, Integer> letterMap = new HashMap<>();
		for (int i=0;i<alphabet.length;i++) {
			   letterMap.put(alphabet[i], alphabet[i] - 'a' + 1);
			}
		return letterMap;
	}
	private int checkChar(String numbers)
	{
		Map<Character, Integer> letterMap = charToInt();
		int sum=0;
		for(int i = 0; i<numbers.length(); i++)
		{
			char c = numbers.charAt(i);
			if(Character.isLetter(c))
			{
				sum += letterMap.get(c);
			}
		}
		return sum;
	}
	private void findNegatives(String[] numbers_arr) throws Exception
	{
		for(int i=0; i<numbers_arr.length; i++) {
			if(Integer.parseInt(numbers_arr[i])<0)
			{
				throw new Exception("Negatives are not allowed " + numbers_arr[i]);
			}
		}
	}
	private boolean empty(String numbers) {
		return numbers.isEmpty();
	}
	
	private int stringToInt(String numbers) {
		return Integer.parseInt(numbers);
	}
}

       