# 🔍 Binary Search — Problem Solutions in Java

A curated collection of **Binary Search** problem solutions written in **Java**, covering classic patterns and advanced applications from **LeetCode** and **GeeksforGeeks**. Every solution is clearly commented with a link to the original problem.

---

## 🧠 Core Concept

Binary Search is applied not just on sorted arrays, but on the **answer space** — a powerful technique where instead of searching for a value in an array, you binary search on the range of possible *answers* and use a feasibility check (`isPossible`) to narrow down to the optimal one.

**The universal pattern used across this repo:**

```java
int low = minPossibleAnswer;
int high = maxPossibleAnswer;
int ans = -1;

while (low <= high) {
    int mid = low + (high - low) / 2;

    if (isPossible(mid, ...)) {
        ans = mid;
        high = mid - 1; // or low = mid + 1 for maximization
    } else {
        low = mid + 1;  // or high = mid - 1
    }
}
```

---

## 📂 Problems Solved

### 🟢 Classic Binary Search on Answer Space

| File | Problem | Platform | Key Idea |
|---|---|---|---|
| `koko-eating-bananas.java` | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) | LeetCode | Binary search on eating speed; minimize speed such that all piles eaten in `h` hours |
| `find-the-smallest-divisor-given-a-threshold.java` | [Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/) | LeetCode | Binary search on divisor; minimize divisor such that ceiling sum ≤ threshold |
| `minimum-number-of-days-to-make-m-bouquets.java` | [Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/) | LeetCode | Binary search on days; check if `m` bouquets of `k` consecutive bloomed flowers possible |
| `minimum-speed-to-arrive-on-time.java` | [Minimum Speed to Arrive on Time](https://leetcode.com/problems/minimum-speed-to-arrive-on-time/) | LeetCode | Binary search on train speed; all trains except last use ceiling division |
| `minimum-time-to-repair-cars.java` | [Minimum Time to Repair Cars](https://leetcode.com/problems/minimum-time-to-repair-cars/) | LeetCode | Binary search on time; mechanic with rank `r` repairs `floor(√(t/r))` cars in time `t` |
| `maximum-candies-allocated-to-k-children.java` | [Maximum Candies Allocated to K Children](https://leetcode.com/problems/maximum-candies-allocated-to-k-children/) | LeetCode | Binary search on candy count per child; maximize allocation |

---

### 🔵 Intermediate — Geometry & Grid

| File | Problem | Platform | Key Idea |
|---|---|---|---|
| `aggressive-cows.java` | [Aggressive Cows](https://www.geeksforgeeks.org/problems/aggressive-cows/1) | GeeksforGeeks | Binary search on minimum distance between cows; classic placement problem |
| `heaters.java` | [Heaters](https://leetcode.com/problems/heaters/) | LeetCode | Binary search on radius; use interval coverage to check all houses are warmed |
| `maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold.java` | [Max Side Length of Square ≤ Threshold](https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/) | LeetCode | Binary search on side length; prefix row sums for O(n²·log(min(m,n))) solution |
| `maximum-white-tiles-covered-by-a-carpet.java` | [Maximum White Tiles Covered by a Carpet](https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/) | LeetCode | Binary search within prefix sums of tile ranges; handle partial tile coverage |

---

### 🔴 Advanced — Multi-Concept

| File | Problem | Platform | Key Idea |
|---|---|---|---|
| `house-robber-iv.java` | [House Robber IV](https://leetcode.com/problems/house-robber-iv/) | LeetCode | Binary search on capability (max stolen value); greedy feasibility check with skip-adjacent |
| `maximum-value-at-a-given-index-in-a-bounded-array.java` | [Maximum Value at a Given Index in a Bounded Array](https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/) | LeetCode | Binary search on peak value at index; math formula for left/right triangle sums |
| `maximum-number-of-removable-characters.java` | [Maximum Number of Removable Characters](https://leetcode.com/problems/maximum-number-of-removable-characters/) | LeetCode | Binary search on number of removals; check if `p` is still subsequence of modified `s` |
| `minimum-absolute-difference-between-elements-with-constraint.java` | [Min Absolute Difference with Constraint](https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/) | LeetCode | TreeSet + `ceiling`/`floor` queries for nearest element at distance ≥ x |
| `earliest-second-to-mark-indices-i.java` | [Earliest Second to Mark Indices I](https://leetcode.com/problems/earliest-second-to-mark-indices-i/) | LeetCode | Binary search on time; track last occurrence of each index and greedily schedule marking |

---

## 🔎 Problem Summaries

### Koko Eating Bananas
Binary search on eating speed from `1` to `max(piles)`. For each speed `mid`, compute total hours needed using `⌈pile/mid⌉`. If total ≤ `h`, try a slower speed.

### Find the Smallest Divisor
Binary search on divisor from `1` to `max(nums)`. Sum of `⌈nums[i]/mid⌉` must be ≤ threshold. Minimize divisor.

### Aggressive Cows (GFG)
Sort stalls. Binary search on minimum distance between any two cows. Greedy check: place cows one by one, only if distance from last placed cow ≥ `mid`.

### Minimum Number of Days to Make m Bouquets
Binary search on number of days. On day `mid`, count consecutive bloomed flowers; group them into bouquets of size `k`. Check if `≥ m` bouquets possible.

### Minimum Speed to Arrive on Time
Binary search on speed. All trains except the last use `⌈dist[i]/speed⌉` hours (wait for next integer hour). Last train uses exact `dist[n-1]/speed`. Total ≤ `hour`.

### Minimum Time to Repair Cars
Binary search on total time `t`. A mechanic with rank `r` can repair `⌊√(t/r)⌋` cars in time `t`. Sum across all mechanics must ≥ `cars`.

### Maximum Candies Allocated to K Children
Binary search on candies per child. Each pile can be split into `pile/mid` portions. Total portions across all piles must ≥ `k`.

### Heaters
Binary search on radius. For each radius `mid`, each heater covers `[heater-mid, heater+mid]`. Sweep houses and heater intervals greedily to check full coverage.

### Maximum Side Length of Square ≤ Threshold
Binary search on side length. Build prefix row sums. For each `mid`, slide all possible `mid×mid` squares and check if any has sum ≤ threshold.

### Maximum White Tiles Covered by a Carpet
Sort tiles. For each tile as the carpet's left start, binary search to find the rightmost tile fully covered. Use prefix sums for covered tile counts and handle partially covered tiles.

### House Robber IV
Binary search on the maximum value (capability) robbed from any house. Greedy feasibility: greedily pick houses with value ≤ `mid`, skipping adjacent ones. Check if `≥ k` houses can be robbed.

### Maximum Value at a Given Index in a Bounded Array
Binary search on the peak value at `index`. Use triangle-sum math to compute the minimum total array sum for a given peak, then check if ≤ `maxSum`.

### Maximum Number of Removable Characters
Binary search on how many indices to remove. Mark removed characters as `#`, then check if `p` is still a subsequence of the modified `s` using two-pointer.

### Minimum Absolute Difference with Constraint
Use a `TreeSet` to maintain a sliding window of elements at distance `≥ x`. For each element `nums[i]`, query `ceiling` and `floor` to find the nearest existing element.

### Earliest Second to Mark Indices I
Binary search on the time window. Track the **last occurrence** of each index in `changeIndices`. Sort indices by last occurrence and greedily schedule `nums[i]+1` operations per index. Check feasibility.

---

## 🛠️ Language & Tools

- **Language:** Java
- **Platforms:** LeetCode, GeeksforGeeks
- **Data Structures:** Arrays, `TreeSet`, prefix sums, `ArrayList`
- **Java APIs:** `Arrays.stream().max/min()`, `Math.sqrt()`, `Math.ceil()`, `TreeSet.ceiling/floor()`

---

## 🚀 How to Run

```bash
# Compile any solution
javac koko-eating-bananas.java

# Run (paste input manually or pipe from file)
java Solution
# or
java Solution < input.txt
```

> Note: Most files use a `Solution` class as required by LeetCode / GFG. Wrap the class in a `Main` with a `main()` method for local testing.

---

## 📈 Topics Covered

| Concept | Problems |
|---|---|
| Binary search on answer (minimize) | Koko, Smallest Divisor, Min Speed, Min Days, Min Time Repair, House Robber IV |
| Binary search on answer (maximize) | Max Candies, Max Value at Index, Max Side Length, Max White Tiles |
| Binary search + Greedy feasibility | Aggressive Cows, Heaters, House Robber IV, Earliest Second |
| Binary search + Prefix sums | Max Side Length, Max White Tiles |
| Binary search + String / Subsequence | Max Removable Characters |
| TreeSet / Sorted set queries | Min Absolute Difference |
| Mathematical formulas in feasibility | Max Value at Index, Min Time Repair |
