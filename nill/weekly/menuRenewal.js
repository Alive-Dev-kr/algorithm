// https://programmers.co.kr/learn/courses/30/lessons/72411

function solution(orders, course) {
  // 조합을 구하기 쉽게 하기 위해 orders의 메뉴를 오름차순 정렬
  let sortedOrders = orders.reduce((sortedOrder, order) => {
    sortedOrder.push(order.split("").sort().join(""));
    return sortedOrder;
  }, []);
  let answer = [];

  // 조합할 수 있는 배열 구하기
  const getCombinations = function (arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((value) => [value]); // 1개씩 택할 때, 바로 모든 배열의 원소 return

    arr.forEach((fixed, index, origin) => {
      const rest = origin.slice(index + 1); // 해당하는 fixed를 제외한 나머지 뒤
      const combinations = getCombinations(rest, selectNumber - 1); // 나머지에 대해서 조합을 구한다.
      const attached = combinations.map((combination) => [fixed, ...combination]); //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
      results.push(...attached); // 배열 spread syntax 로 모두 다 push
    });

    return results; // 결과가 담긴 results를 return
  };

  //  뽑는 개수에 따라서 조합 구하기
  course.forEach((num) => {
    // 조합으로 구한 코스 메뉴의 모든 경우가 키가 되고 주문횟수를 값으로 하는 변수.
    let courseMenus = [];

    // 각 order마다 조합 구하기
    sortedOrders.forEach((order) => {
      let orderList = getCombinations(order.split(""), num);
      orderList.forEach((courseMenu) => {
        if (courseMenu in courseMenus) {
          courseMenus[courseMenu]++;
        } else {
          courseMenus[courseMenu] = 1;
        }
      });
    });

    let orderCnt = 2;
    let tempCourseMenu = [];

    // 코스 메뉴의 order 횟수가 2이상일때 temp 배열에 넣음.
    // order 횟수의 최대값이 바뀌면 temp 새로 초기화
    for (const courseMenu in courseMenus) {
      if (courseMenus[courseMenu] > orderCnt) {
        orderCnt = courseMenus[courseMenu];
        tempCourseMenu = [courseMenu];
      } else if (courseMenus[courseMenu] === orderCnt) {
        tempCourseMenu.push(courseMenu);
      }
    }
    const courseMenu = tempCourseMenu.map((courseMenu) => {
      return courseMenu.replace(/,/gi, "");
    });
    answer.push(...courseMenu);
    answer.sort();
  });

  return answer;
}

const orders1 = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"];
const orders2 = ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"];
const orders3 = ["XYZ", "XWY", "WXA"];
const course1 = [2, 3, 4];
const course2 = [2, 3, 5];
const course3 = [2, 3, 4];

console.log(solution(orders1, course1)); // ["AC", "ACDE", "BCFG", "CDE"]
console.log(solution(orders2, course2)); // ["ACD", "AD", "ADE", "CD", "XYZ"]
console.log(solution(orders3, course3)); //	["WX", "XY"]
