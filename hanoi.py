import sys

def hanoi(n, src, dst, aux):
    if n == 1:
        print(f"Move disk 1 from {src} to {dst}")
        return
    hanoi(n-1, src, aux, dst)
    print(f"Move disk {n} from {src} to {dst}")
    hanoi(n-1, aux, dst, src)

if __name__ == '__main__':
    n = int(sys.argv[1]) if len(sys.argv) > 1 else 3
    hanoi(n, 'A', 'C', 'B')
