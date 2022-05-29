// https://programmers.co.kr/learn/courses/30/lessons/42888?language=javascript

function solution(record) {
  let answer = [];
  let dic = {};
  for (const a of record) {
    let splitedRecord = a.split(" ");
    if (splitedRecord[0] === "Enter") {
      dic[splitedRecord[1]] = [splitedRecord[2]];
    }
    if (splitedRecord[0] === "Change") {
      dic[splitedRecord[1]] = [splitedRecord[2]];
    }
  }
  for (const a of record) {
    let splitedRecord = a.split(" ");
    if (splitedRecord[0] === "Enter") {
      answer.push(dic[splitedRecord[1]] + "님이 들어왔습니다.");
    }
    if (splitedRecord[0] === "Leave") {
      answer.push(dic[splitedRecord[1]] + "님이 나갔습니다.");
    }
  }

  return answer;
}

record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"];
console.log(solution(record)); //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
