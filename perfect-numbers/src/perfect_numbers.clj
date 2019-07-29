(ns perfect-numbers)

(def sum (partial reduce + 0))
(defn factors [n]
  (->> n
       (range 1)
       (filter #(= 0 (mod n %)))))

(defn abundant? [n]
  (> (sum (factors n)) n))

(defn deficient? [n]
  (< (sum (factors n)) n))

(defn classify [n] 
  (cond
    (neg? n) (throw (IllegalArgumentException. "Uh Oh"))
    (abundant? n) :abundant
    (deficient? n) :deficient
    :else :perfect))
