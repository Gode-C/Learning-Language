def pyramid(h):
    h = abs(h)
    if h == 0:
        return 0
    if h == 1:
        return 1
    else:
        return h ** 2 + pyramid(h - 1)
