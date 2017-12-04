package main

import "fmt"

func factorial(target int) (answer int) {
	// Factorial function
	answer = 1
	if target < 0 {
		return
	} else {
		for i := 1; i <= target; i++ {
			answer = answer * i
		}
		return
	}
}

func main() {
	var target, answer int
	fmt.Print("input factorial target : ")
	fmt.Scanf("%d", &target)
	answer = factorial(target)
	fmt.Println("factorial for", target, "is", answer)
}
