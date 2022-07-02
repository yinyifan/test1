package com.yyf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		String digits = "567";
//		System.out.println(letterCombinations(digits));
		//test();
		SpringApplication.run(DemoApplication.class, args);
	}


	private static void test(){
		int[] test =new int[2];
		test[1]=1;
		test[0]=0;
		Arrays.sort(test);
		System.out.println(test);
		int result = Arrays.binarySearch(test,10);
		System.out.println(result);
		for(int i=0;i<test.length;i++)    //length is the property of the array
			System.out.print(test[i]);
	}

	public static List<String> letterCombinations(String digits) {
		int noOfInput= digits.length();
		if(noOfInput==0){
			return new ArrayList<>();
		}
		Map<Integer, char[]> letters = new HashMap<>();
		letters.put(2, new char[]{'a', 'b', 'c'});
		letters.put(3, new char[]{'d', 'e', 'f'});
		letters.put(4, new char[]{'g', 'h', 'i'});
		letters.put(5, new char[]{'j', 'k', 'l'});
		letters.put(6, new char[]{'m', 'n', 'o'});
		letters.put(7, new char[]{'p', 'q', 'r', 's'});
		letters.put(8, new char[]{'t', 'u', 'v'});
		letters.put(9, new char[]{'w', 'x', 'y', 'z'});

		List<char[]> inputLetters = new ArrayList<>();

		int max=1;
		int sumOfSecondThird=1 ,sumOfThirdFourthInput=1,sumOfSecondThirdFourthInput=1;

		//first step find letters in scope and combinations for last nth inputs
		for(int i=0; i<digits.length();i++) {
			char [] charForNum = letters.get(Integer.parseInt(String.valueOf(digits.charAt(i))));
			inputLetters.add(charForNum);
			max *= charForNum.length;
			if(noOfInput == 3 && i>0){
				sumOfSecondThird *= charForNum.length;

			}
			if(noOfInput == 4 ){
				//i in 0,1,2,3
				if(i==1){
					sumOfSecondThirdFourthInput *=charForNum.length;
				}
				else if (i>1){
					sumOfSecondThirdFourthInput *=charForNum.length;
					sumOfThirdFourthInput *=charForNum.length;
				}
			}
		}

		List<String> output = new ArrayList<>();
		int count=1;
		for(int i =0; i <max; i++) {
		    StringBuilder sb =new StringBuilder();
            for(int inputSeq =0; inputSeq<noOfInput;inputSeq++) {
				if(noOfInput==1){
					sb.append(determineLetter(count,inputLetters.get(0)));
				}else if(noOfInput==2){
					sb.append(determineLetter(count,max,inputSeq,inputLetters));
				}else if(noOfInput==3){
					sb.append(determineLetter(inputSeq,inputLetters,count,max,noOfInput, sumOfSecondThird));
				}else{
					sb.append(determineLetter(inputSeq,inputLetters,count,max,noOfInput, sumOfThirdFourthInput,sumOfSecondThirdFourthInput));
				}
			}
			output.add(sb.toString());
			sb.setLength(0);
			count++;
		}

		return output;
	}

	//3 input
	private static char determineLetter(int inputSeq, List<char[]> inputLetters, int count, int max, int noOfInput, int sumOfSecondThird) {
		char[] inputArray = inputLetters.get(inputSeq);

		//first and last output fixed pattern
		if(inputSeq==noOfInput-1){
			return inputArray[(count-1)%inputArray.length];
		}
		else if(inputSeq==0){
			int unitCount = max/inputArray.length;
			return inputArray[(count-1)/unitCount];
		}
		//for 3 inputs,second input
		else{
			return inputArray[count%(sumOfSecondThird)/(inputLetters.get(noOfInput-1).length+1)];
		}
	}

	//2 input
	private static char determineLetter(int count, int max, int inputSeq, List<char[]> inputLetters) {
		char[] inputArray = inputLetters.get(inputSeq);
		//first and last output fixed pattern
		if(inputSeq==1){
			return inputArray[count%inputArray.length];
		}
		else {
			int unitCount = max/inputArray.length;
			return inputArray[(count-1)/unitCount];
		}
	}

	//1 input
	private static char determineLetter(int count, char[] chars) {
		return chars[count-1];
	}


	//4 input
	private static char determineLetter(int inputSeq, List<char[]> inputLetters, int count, int max, int noOfInput, int sumOfThirdFourthInput,int sumOfSecondThirdFourthInput) {
		char[] inputArray = inputLetters.get(inputSeq);

		//first and last output fixed pattern
		if(inputSeq==3){
			return inputArray[count%inputArray.length];
		}else if(inputSeq==0){
			int unitCount = max/inputArray.length;
			return inputArray[(count-1)/unitCount];
		}else if(inputSeq==2){
			int index= count%(sumOfThirdFourthInput)/(inputLetters.get(noOfInput-1).length+1);
			return inputArray[index];
		}else{
			int index= count%(sumOfSecondThirdFourthInput)/(sumOfThirdFourthInput+1);
			return inputArray[index];
		}
	}
}


