(ns space-age)

(def earth-seconds-per-year 31557600)
(defn earth-age [n]
  "Converts age seconds into years for earth"
  (float (/ n earth-seconds-per-year)))

(defn on-mercury [n] 
  (/ (earth-age n) 0.2408467))

(defn on-venus [n] 
  (/ (earth-age n) 0.61519726))

(defn on-earth [n]
  (/ (earth-age n) 1))

(defn on-mars [n]
  (/ (earth-age n) 1.8808158 ))

(defn on-jupiter [n] 
  (/ (earth-age n) 11.862615))

(defn on-saturn [n]
  (/ (earth-age n) 29.447468))

(defn on-neptune [n]
  (/ (earth-age n) 164.79132))

(defn on-uranus [n]
  (/ (earth-age n) 84.016846))


