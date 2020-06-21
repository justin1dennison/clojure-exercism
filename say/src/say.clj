(ns say)

(def small-numbers ["zero", "one", "two", "three", "four", "five", "six",
                    "seven", "eight", "nine", "ten", "eleven", "twelve",
                    "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                    "eighteen", "nineteen"])

(def tens ["twenty", "thirty", "forty", "fifty", "sixty",
           "seventy", "eighty", "ninety"])

(def thousands 1000)
(def millions 1000000)
(def billions 1000000000)
(def trillions 1000000000000)

(defn number [num]
  (cond
    (not (<= 0 num (dec trillions))) (throw (IllegalArgumentException. "Invalid Number"))
    (< num 20) (get small-numbers num)
    (< num 100) (let [base (get tens (- (quot num 10) 2))
                      remainder (mod num 10)
                      ones  (get small-numbers remainder)]
                  (if (zero? remainder) base (str base "-" ones)))
    (< num thousands) (let [d (quot num 100)
                            remainder (mod num 100)
                            base (get small-numbers d)
                            unit "hundred"]
                        (if (zero? remainder)
                          (str base " " unit)
                          (str (number d) " " unit " " (number remainder))))
    (< num millions) (let [d (quot num 1000)
                           remainder (mod num 1000)
                           base (get small-numbers d)
                           unit "thousand"]
                       (if (zero? remainder)
                         (str base " " unit)
                         (str (number d) " " unit " " (number remainder))))
    (< num billions) (let [d (quot num 1000000)
                           remainder (mod num 1000000)
                           base (get small-numbers d)
                           unit "million"]
                       (if (zero? remainder)
                         (str base " " unit)
                         (str (number d) " " unit " " (number remainder))))
    :else (let [d (quot num 1000000000)
                remainder (mod num 1000000000)
                base (get small-numbers d)
                unit "billion"]
            (if (zero? remainder)
              (str base " " unit)
              (str (number d) " " unit " " (number remainder))))))

