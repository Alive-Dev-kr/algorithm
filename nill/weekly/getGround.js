// https://programmers.co.kr/learn/courses/30/lessons/12913?language=javascript

function solution(land) {
  let answer = 0;

  // 모든 경우의 수를 구하면 최대 4^100,000까지 나오기 때문에 당연히 안됌.
  // land의 모든 수를 내림차순으로 sort해서 행의 수 만큼만 뽑아 이 수를 기준으로 최대값 구하기 =>100,000^2

  // 한 줄씩 최대값이 될 수 있는 수를 더하는 배열
  // 바라보는 행에서 곧장 최대값을 쌓는다는게 아이디어-!
  let append_line = land[0];

  for (let i in land) {
    //
    let temp = [...append_line];
    if (i > 0) {
      append_line[0] = Math.max(temp[1], temp[2], temp[3]) + land[i][0];
      append_line[1] = Math.max(temp[0], temp[2], temp[3]) + land[i][1];
      append_line[2] = Math.max(temp[0], temp[1], temp[3]) + land[i][2];
      append_line[3] = Math.max(temp[0], temp[1], temp[2]) + land[i][3];
    }
  }

  console.log(append_line);
  answer = Math.max(...append_line);

  return answer;
}
