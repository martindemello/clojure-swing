(ns swing.helpers.keyboard
  (:import
     (java.awt.event KeyListener KeyAdapter KeyEvent InputEvent)))

(defn char-of [e] (. KeyEvent getKeyText (. e getKeyCode)))
(defn modifier [e] (. e getModifiers))
(defn modtext [e] (. KeyEvent getKeyModifiersText (modifier e)))
(def CTRL (. InputEvent CTRL_MASK))
(def ALT (. InputEvent ALT_MASK))
(defn ctrl? [e] (= CTRL (bit-and (modifier e) CTRL)))
(defn alt? [e] (= ALT (bit-and (modifier e) ALT)))

(defn add-key-pressed-listener [component f & args]
  (let [listener (proxy [KeyAdapter] []
                   (keyPressed [e] (apply f e args)))]
    (.addKeyListener component listener)
    listener))
