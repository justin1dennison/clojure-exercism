(ns say)

(def small-numbers ["zero", "one", "two", "three", "four", "five", "six",
                    "seven", "eight", "nine", "ten", "eleven", "twelve",
                    "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                    "eighteen", "nineteen"])

(def tens ["twenty", "thirty", "forty", "fifty", "sixty",
           "seventy", "eighty", "ninety"])

(def trillions 1e12)

(def ^:private ^:const mags
  [[1000000000 "billion"]
   [1000000    "million"]
   [1000       "thousand"]
   [100        "hundred"]])

(defn select [n]
  (first
   (drop-while
    #(< n (first %)) mags)))

(defn number [num]
  (cond
    (not (<= 0 num (dec trillions))) (throw (IllegalArgumentException. "Invalid Number"))
    (< num 20) (get small-numbers num)
    (< num 100) (let [base (get tens (- (quot num 10) 2))
                      remainder (mod num 10)
                      ones  (get small-numbers remainder)]
                  (if (zero? remainder) base (str base "-" ones)))
    :else (let [[value unit] (select num)
                d (quot num value)
                remainder (mod num value)
                base (get small-numbers d)]
            (if (zero? remainder)
              (str base " " unit)
              (str (number d) " " unit " " (number remainder))))))
