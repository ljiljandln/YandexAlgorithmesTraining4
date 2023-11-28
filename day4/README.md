# A. Все перестановки заданной длины

|   |   |
|---|---|
|Ограничение времени|2 секунды|
|Ограничение памяти|64Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

По данному числу N (0 < N < 10) выведите все перестановки чисел от 1 до N в лексикографическом порядке.

### Пример 1

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|1|1|

### Пример 2

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|2|12<br>21|

### Пример 3

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|3|123<br>132<br>213<br>231<br>312<br>321|

___
# B. Затерянный мир

|   |   |
|---|---|
|Ограничение времени|1 секунда|
|Ограничение памяти|64Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

Территория зоопарка Юрского периода «Затерянный мир» представляет собой решётку N × N, в каждой клетке которой находится вольер для динозавра. Директор зоопарка Степан Савельев планирует расселить в зоопарке N динозавров. Вольеры отделены друг от друга невысоким забором. Сотрудникам зоопарка известно, что динозавр не покидает пределов своего вольера, и не ломает забор, если он не видит на территории парка других динозавров. Зрительный аппарат у динозавров таков, что он видит всех динозавров, которые находятся на одной строке, на одном столбце или на одной диагонали с ним. Если же динозавр видит другого ящера, то ломает забор и вступает в борьбу. Директор зоопарка не хочет терпеть убытки, поэтому просит вас посчитать количество способов так расселить динозавров в зоопарке, чтобы никакой ящер не видел остальных динозавров.

## Формат ввода

Задано единственное число N (N ≤ 10).

## Формат вывода

Необходимо вывести количество способов, которыми можно расселить в зоопарке N динозавров, чтобы у зоопарка не было убытков.

## Пример

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|8|92|

___
# C. Максимальный разрез

|   |   |
|---|---|
|Ограничение времени|1 секунда|
|Ограничение памяти|64Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

Взвешенный неориентированный граф без петель задан матрицей смежности. Распределите вершины по двум долям так, чтобы сумма весов рёбер, соединяющих вершины из разных долей, была максимальна.

## Формат ввода

Вводится число N (2 ≤ N ≤ 20) — количество вершин в графе.

В следующих N строках, содержащих по N целых чисел от 0 до 1000, задаётся матрица смежности. 0 означает отсутствие ребра.

## Формат вывода

В первой строке выведите суммарный вес рёбер, соединяющих вершины из разных долей.

Во второй строке выведите N чисел 1 или 2 — номера долей для каждой из вершин графа.

### Пример 1

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|2<br>0 1<br>1 0|1<br>2 1|

### Пример 2

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|3<br>0 1 2<br>1 0 2<br>2 2 0|4<br>2 2 1|

### Пример 3

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|4<br>0 10 3 0<br>10 0 7 2<br>3 7 0 9<br>0 2 9 0|

___
# D. Простая задача коммивояжера

|   |   |
|---|---|
|Ограничение времени|2 секунды|
|Ограничение памяти|64Mb|
|Ввод|стандартный ввод или input.txt|
|Вывод|стандартный вывод или output.txt|

Неориентированный взвешенный граф задан матрицей смежности. Найдите кратчайший цикл, который начинается и заканчивается в вершине номер 1 и проходит через все вершины по одному разу.

## Формат ввода

В первой строке вводится число N (N ≤ 10) — количество вершин графа. Следующие N строк содержат по N целых неотрицательных чисел и задают матрицу смежности. Число 0 означает, что ребро отстутствует. Любое другое число задаёт вес ребра.

## Формат вывода

Выведите минимальную суммарную длину цикла или число -1, если цикл построить невозможно.

### Пример 1

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|1<br>0|0|

### Пример 2

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|2<br>0 1<br>1 0|2|

### Пример 3

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|2<br>0 85 <br>85 0|

___
# E. Генерация правильных скобочных последовательностей - 2

|   |   |
|---|---|
|Ограничение времени|2 секунды|
|Ограничение памяти|64Mb|
|Ввод|стандартный ввод или brackets2.in|
|Вывод|стандартный вывод или brackets2.out|

По данному числу n выведите все правильные скобочные последовательности из круглых и квадратных скобок длины n в лексикографическом порядке.

## Формат ввода

Одно целое число n (0 ≤ n ≤ 16).

## Формат вывода

Выведите все правильные скобочные последовательности из круглых и квадратных скобок длины n в лексикографическом порядке. Каждая последовательность должна выводиться в новой строке.

## Пример

|Ввод<br><br> ![Скопировать ввод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|Вывод<br><br> ![Скопировать вывод](https://yastatic.net/lego/_/La6qi18Z8LwgnZdsAr1qy1GwCwo.gif)|
|---|---|
|4|(())<br>([])<br>()()<br>()[]<br>[()]<br>[[]]<br>[]()<br>[][]|

___