## Exercise 3 - Technical Comparison of an SQL and Graph Database

Ismail Cam and Mazlum Dogan Sert

---

### Results

<table width="100%">
    <thead>
    <tr>
        <th>Queries</th>
        <th>Neo4j AVG</th>
        <th>Neo4j Median</th>
        <th>MySQL AVG</th>
        <th>MySQL Median</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Depth one</td>
        <td>382,91 ms</td>
        <td>379,88 ms</td>
        <td>1,05 ms</td>
        <td>0,48 ms</td>
    </tr>
    <tr>
        <td>Depth two</td>
        <td>451,08 ms</td>
        <td>432,71 ms</td>
        <td>6,31 ms</td>
        <td>2,15 ms</td>
    </tr>
    <tr>
        <td>Depth three</td>
        <td>565,64 ms</td>
        <td>531,81 ms</td>
        <td>42,44 ms</td>
        <td>19,87 ms</td>
    </tr>
    <tr>
        <td>Depth four</td>
        <td>2154,61 ms</td>
        <td>1093,20 ms</td>
        <td>764,64 ms</td>
        <td>317,86 ms</td>
    </tr>
    <tr>
        <td>Depth five</td>
        <td>28957,16 ms</td>
        <td>12338,80 ms</td>
        <td>∞</td>
        <td>∞</td>
    </tr>
    </tbody>
</table>