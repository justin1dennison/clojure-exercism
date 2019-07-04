(ns series)

(defn transform-maker [length]
  (comp
   (partial map clojure.string/join)
   #(partition length 1 %)))

(defn slices [string length]
  (if (zero? length)
    [""]
    ((transform-maker length) string)))
