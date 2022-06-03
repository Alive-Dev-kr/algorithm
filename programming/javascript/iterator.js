const products = [
  { name: "반팔티", price: 15000 },
  { name: "긴팔티", price: 20000 },
  { name: "후드티", price: 30000 },
  { name: "바지", price: 25000 },
  { name: "폰케이스", price: 15000 },
];

const reduce = (f, iter) => {
  let total = 0;
  for (a of iter) {
    total = f(total, a);
  }
  return total;
};

const map = (f, iter) => {
  let res = [];
  for (const a of iter) {
    // a = { name: "반팔티", price: 15000 }
    res.push(f(a));
  }
  return res;
};

const filter = (f, iter) => {
  let res = [];
  for (const a of iter) {
    if (f(a)) res.push(a);
  }
  return res;
};

console.log(
  reduce(
    (a, b) => a + b,
    filter(
      (price) => price >= 20000,
      map((p) => p.price, products)
    ) // [ 15000, 20000, 30000, 25000, 15000 ] => [20000, 30000, 25000]
  )
);
