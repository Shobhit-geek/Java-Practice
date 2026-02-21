// Destructuring in JavaScript is a syntax that lets you extract values from arrays or 
// properties from objects and assign them to variables in a clean, readable way.

// 5️⃣ Why Use Destructuring?

// ✅ Cleaner code
// ✅ Less repetition
// ✅ Improves readability
// ✅ Common in modern JS / TypeScript / React

// “Rest vs Spread operator – what’s the difference?”, keep it short, clear, and confident.

// ✅ Best Interview Answer (30 seconds)

// Both rest and spread use the same ... syntax, but their purpose is opposite.
// Spread is used to expand an array or object into individual elements (usually on the right-hand side).
// Rest is used to collect multiple elements into a single array or object (usually on the left-hand side).
// In short: spread breaks things apart, rest puts things together.

// 🔹 One-line version (super crisp)

// Spread expands values, rest collects values — context decides the behavior of ....

// 🔹 If they want a quick example
// // Spread
// const newArr = [...oldArr];

// // Rest
// const [first, ...rest] = arr;

// 🔹 If interviewer probes deeper

// Spread is commonly used for immutability (copying/merging objects, React state updates),
// while rest is commonly used for variable-length function arguments and destructuring.

// 🔹 Final interview rule to remember

// Right side → Spread
// Left side → Rest