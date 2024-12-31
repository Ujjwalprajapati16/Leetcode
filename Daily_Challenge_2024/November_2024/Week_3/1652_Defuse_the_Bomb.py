from typing import List

class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        N = len(code)
        res = [0] * N

        if k == 0:
            return res

        start, end = (1, k) if k > 0 else (k, -1)

        window_sum = sum(code[i % N] for i in range(start, end + 1))

        for i in range(N):
            res[i] = window_sum

            window_sum -= code[(i + start) % N]
            window_sum += code[(i + end + 1) % N]

        return res