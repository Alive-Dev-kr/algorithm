// https://programmers.co.kr/learn/courses/30/lessons/77485?language=javascript

function solution(rows, columns, queries) {
  const matrix = []; // row, columns에 맞게 이차행렬 생성을 위한 변수
  let answer = [];

  // row, columns에 맞게 이차행렬 생성
  for (let i = 0; i < rows; i++) {
    let rowMatrix = [];
    for (let j = 1; j <= columns; j++) {
      rowMatrix.push(j + columns * i);
    }
    matrix.push([...rowMatrix]);
  }

  // 각각의 query 규칙에 맞게 돌림
  for (const query of queries) {
    const matrixCopy = []; //
    const changedNums = [];

    const startRow = query[0];
    const startCol = query[1];
    const endRow = query[2];
    const endCol = query[3];

    // 이차행렬 깊은복사
    for (const i in matrix) {
      matrixCopy[i] = [...matrix[i]];
    }

    // 위
    for (let a = startCol; a < endCol; a++) {
      matrix[startRow - 1][a] = matrixCopy[startRow - 1][a - 1];
      changedNums.push(matrixCopy[startRow - 1][a - 1]);
    }

    // 오른쪽
    for (let a = startRow; a < endRow; a++) {
      matrix[a][endCol - 1] = matrixCopy[a - 1][endCol - 1];
      changedNums.push(matrixCopy[a - 1][endCol - 1]);
    }

    // 왼쪽
    for (let a = endCol; a > startCol; a--) {
      matrix[endRow - 1][a - 2] = matrixCopy[endRow - 1][a - 1];
      changedNums.push(matrixCopy[endRow - 1][a - 1]);
    }

    // 아래
    for (let a = endRow; a > startRow; a--) {
      matrix[a - 2][startCol - 1] = matrixCopy[a - 1][startCol - 1];
      changedNums.push(matrixCopy[a - 1][startCol - 1]);
    }

    changedNums.sort((a, b) => a - b);
    answer.push(changedNums[0]);
  }
  return answer;
}

const rows1 = 6;
const rows2 = 3;
const rows3 = 100;
const columns1 = 6;
const columns2 = 3;
const columns3 = 97;
const queries1 = [
  [2, 2, 5, 4],
  [3, 3, 6, 6],
  [5, 1, 6, 3],
];
const queries2 = [
  [1, 1, 2, 2],
  [1, 2, 2, 3],
  [2, 1, 3, 2],
  [2, 2, 3, 3],
];
const queries3 = [[1, 1, 100, 97]];

console.log(solution(rows1, columns1, queries1));
console.log(solution(rows2, columns2, queries2));
console.log(solution(rows3, columns3, queries3));
