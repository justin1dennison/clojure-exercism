(ns sum-of-multiples)

(def sum (partial reduce + 0))


(defn- multiple-of? [digits n]
  (some 
    identity 
    (for [d digits] (= 0 (mod n d)))))

(defn sum-of-multiples [digits n]
  (sum
   (filter 
     (partial multiple-of? digits) 
     (range 1 n))))
