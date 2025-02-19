let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let count = parseInt(input[0].split(" ")[0]);
let M = parseInt(input[0].split(" ")[1]);

let cards = input[1].split(" ").map(Number);
let maxSum = 0;

// 3중 for문으로 서로 다른 3장의 카드를 선택
for (let i = 0; i < count - 2; i++) {
  for (let j = i + 1; j < count - 1; j++) {
    for (let k = j + 1; k < count; k++) {
      let sum = cards[i] + cards[j] + cards[k];

      // 합이 M을 넘지 않고, 지금까지의 최대 합보다 크다면 갱신
      if (sum <= M && sum > maxSum) {
        maxSum = sum;
      }
    }
  }
}

console.log(maxSum);
